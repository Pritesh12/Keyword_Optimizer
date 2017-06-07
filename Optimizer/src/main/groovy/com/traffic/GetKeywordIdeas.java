package com.traffic;// Copyright 2016 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import com.google.api.ads.adwords.axis.factory.AdWordsServices;
import com.google.api.ads.adwords.axis.v201609.cm.Language;
import com.google.api.ads.adwords.axis.v201609.cm.Money;
import com.google.api.ads.adwords.axis.v201609.cm.NetworkSetting;
import com.google.api.ads.adwords.axis.v201609.cm.Paging;
import com.google.api.ads.adwords.axis.v201609.o.*;
import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.auth.OfflineCredentials.Api;
import com.google.api.ads.common.lib.utils.Maps;
import com.google.api.client.auth.oauth2.Credential;
import com.google.common.base.Joiner;
import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Map;

/**
 * This example gets keywords related to a seed keyword.
 *
 * <p>Credentials and properties in {@code fromFile()} are pulled from the
 * "ads.properties" file. See README for more info.
 */
public class GetKeywordIdeas {

  public static void main(String[] args) throws Exception {
    // Generate a refreshable OAuth2 credential.
    Credential oAuth2Credential = new OfflineCredentials.Builder()
        .forApi(Api.ADWORDS)
        .fromFile()
        .build()
        .generateCredential();

    // Construct an AdWordsSession.
    AdWordsSession session = new AdWordsSession.Builder()
        .fromFile()
        .withOAuth2Credential(oAuth2Credential)
        .build();

    AdWordsServices adWordsServices = new AdWordsServices();

    runExample(adWordsServices, session,null);
  }

  public static ArrayList<GetDTO> runExample(
      AdWordsServices adWordsServices, AdWordsSession session,String userinput) throws Exception {
    // Get the TargetingIdeaService.

	  
	  String key=userinput;
    TargetingIdeaServiceInterface targetingIdeaService =
        adWordsServices.get(session, TargetingIdeaServiceInterface.class);

    // Create selector.
    TargetingIdeaSelector selector = new TargetingIdeaSelector();
    selector.setRequestType(RequestType.IDEAS);
    selector.setIdeaType(IdeaType.KEYWORD);
    selector.setRequestedAttributeTypes(new AttributeType[] {
        AttributeType.KEYWORD_TEXT,
        AttributeType.SEARCH_VOLUME,
        AttributeType.CATEGORY_PRODUCTS_AND_SERVICES,
        AttributeType.AVERAGE_CPC,
        AttributeType.COMPETITION});

    // Set selector paging (required for targeting idea service).
    Paging paging = new Paging();
    paging.setStartIndex(0);
    paging.setNumberResults(10);
    selector.setPaging(paging);

    // Create related to query search parameter.
    RelatedToQuerySearchParameter relatedToQuerySearchParameter =
        new RelatedToQuerySearchParameter();
    relatedToQuerySearchParameter.setQueries(new String[] {key});

    // Language setting (optional).
    // The ID can be found in the documentation:
    //   https://developers.google.com/adwords/api/docs/appendix/languagecodes
    // See the documentation for limits on the number of allowed language parameters:
    //   https://developers.google.com/adwords/api/docs/reference/latest/TargetingIdeaService.LanguageSearchParameter
    LanguageSearchParameter languageParameter = new LanguageSearchParameter();
    Language english = new Language();
    english.setId(1000L);
    languageParameter.setLanguages(new Language[] {english});

    // Create network search parameter (optional).
    NetworkSetting networkSetting = new NetworkSetting();
    networkSetting.setTargetGoogleSearch(true);
    networkSetting.setTargetSearchNetwork(false);
    networkSetting.setTargetContentNetwork(false);
    networkSetting.setTargetPartnerSearchNetwork(false);
    
    NetworkSearchParameter networkSearchParameter = new NetworkSearchParameter();
    networkSearchParameter.setNetworkSetting(networkSetting);
    
    selector.setSearchParameters(
        new SearchParameter[] {relatedToQuerySearchParameter, languageParameter,
            networkSearchParameter});

    // Get related keywords.
    TargetingIdeaPage page = targetingIdeaService.get(selector);
    ArrayList<GetDTO> getDTOS=new ArrayList<>();
    // Display related keywords.
    if (page.getEntries() != null && page.getEntries().length > 0) {
      for (TargetingIdea targetingIdea : page.getEntries()) {
        Map<AttributeType, Attribute> data = Maps.toMap(targetingIdea.getData());
        StringAttribute keyword = (StringAttribute) data.get(AttributeType.KEYWORD_TEXT);

        IntegerSetAttribute categories =
            (IntegerSetAttribute) data.get(AttributeType.CATEGORY_PRODUCTS_AND_SERVICES);

        String categoriesString = "(none)";
        if (categories != null && categories.getValue() != null) {
          categoriesString = Joiner.on(", ").join(Ints.asList(categories.getValue()));
        }

        GetDTO getDTO=new GetDTO();

        Long averageMonthlySearches =
            ((LongAttribute) data.get(AttributeType.SEARCH_VOLUME))
                .getValue();


          Money cost = ((MoneyAttribute) data.get(AttributeType.AVERAGE_CPC)).getValue();

          getDTO.setAveragemonthlysearch(averageMonthlySearches);

          /*doesn't implied */

            getDTO.setCost(cost);
          getDTO.setKeyword(keyword.getValue());
        getDTOS.add(getDTO);

      //  Double cost = ((DoubleAttribute) data.get(AttributeType.AVERAGE_CPC)).getValue();
        System.out.printf("'%s',%d,'%s' "
            + "%s%n", keyword.getValue(), averageMonthlySearches,
                cost,categoriesString);
      }
    } else {
      System.out.println("No related keywords were found.");
    }

    return getDTOS;

  }

}

package com.searchkeyword

import com.google.api.ads.adwords.axis.factory.AdWordsServices
import com.google.api.ads.adwords.lib.client.AdWordsSession
import com.google.api.ads.common.lib.auth.OfflineCredentials
import com.google.api.ads.common.lib.conf.ConfigurationLoadException
import com.google.api.ads.common.lib.exception.OAuthException
import com.google.api.ads.common.lib.exception.ValidationException
import com.google.api.client.auth.oauth2.Credential
import com.traffic.BeanDTO
import com.traffic.EstimateKeywordTraffic
import com.traffic.GetKeywordIdeas
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SearchKeywordController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        /*params.max = Math.min(max ?: 10, 100)
        respond SearchKeyword.list(params), model: [searchKeywordCount: SearchKeyword.count()]*/
        Properties properties = new Properties();
      //  properties.load(SearchKeywordController.class.getResourceAsStream("ads.properties"));
        properties.getProperty("ads.properties")
        String userinput = request.getParameter("search");

        Credential oAuth2Credential = null;
        try {
            oAuth2Credential = new OfflineCredentials.Builder()
                    .forApi(OfflineCredentials.Api.ADWORDS)
                    .fromFile()
                    .build()
                    .generateCredential();
        } catch (OAuthException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ValidationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ConfigurationLoadException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Construct an AdWordsSession.
        AdWordsSession session = null;
        try {
            session = new AdWordsSession.Builder()
                    .fromFile()
                    .withOAuth2Credential(oAuth2Credential)
                    .build();
        } catch (ValidationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ConfigurationLoadException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        AdWordsServices adWordsServices = new AdWordsServices();
        ArrayList<EstimateKeywordTraffic> estimateKeywordTraffics= new ArrayList<>();

        EstimateKeywordTraffic ekt = new EstimateKeywordTraffic();

        ekt.runExample(adWordsServices, session, userinput)
         String meanClicks= ekt.runExample(adWordsServices, session, userinput).meanClicks
        String meanAveragePosition= ekt.runExample(adWordsServices, session, userinput).meanAveragePosition
        String meanAverageCpc= ekt.runExample(adWordsServices, session, userinput).meanAverageCpc
       // String meanTotalCost= ekt.runExample(adWordsServices, session, userinput).meanTotalCost
        GetKeywordIdeas getKeywordIdeas=new GetKeywordIdeas()

            String keyword=getKeywordIdeas.runExample(adWordsServices, session, userinput).keyword
            String cost=getKeywordIdeas.runExample(adWordsServices, session, userinput).cost
            String averagemonthlysearch=getKeywordIdeas.runExample(adWordsServices, session, userinput).averagemonthlysearch


        estimateKeywordTraffics.add(ekt);

       /* def searchKeyword = new SearchKeyword()
        searchKeyword.search =ekt.runExample(adWordsServices, session, userinput)*/
        //render view: 'result'
        render(view: 'result', model:[searchKeyword:userinput,meanClicks:meanClicks,meanAveragePosition:meanAveragePosition,meanAverageCpc:meanAverageCpc,keyword:keyword,cost:cost,averagemonthlysearch:averagemonthlysearch] )
    }


     /*   def show(SearchKeyword searchKeyword) {
            respond searchKeyword
        }

        def create() {
            respond new SearchKeyword(params)
        }

        @Transactional
        def save(SearchKeyword searchKeyword) {
            if (searchKeyword == null) {
                transactionStatus.setRollbackOnly()
                notFound()
                return
            }

            if (searchKeyword.hasErrors()) {
                transactionStatus.setRollbackOnly()
                respond searchKeyword.errors, view: 'create'
                return
            }

            searchKeyword.save flush: true

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.created.message', args: [message(code: 'searchKeyword.label', default: 'SearchKeyword'), searchKeyword.id])
                    redirect searchKeyword
                }
                '*' { respond searchKeyword, [status: CREATED] }
            }
        }

        def edit(SearchKeyword searchKeyword) {
            respond searchKeyword
        }

        @Transactional
        def update(SearchKeyword searchKeyword) {
            if (searchKeyword == null) {
                transactionStatus.setRollbackOnly()
                notFound()
                return
            }

            if (searchKeyword.hasErrors()) {
                transactionStatus.setRollbackOnly()
                respond searchKeyword.errors, view: 'edit'
                return
            }

            searchKeyword.save flush: true

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.updated.message', args: [message(code: 'searchKeyword.label', default: 'SearchKeyword'), searchKeyword.id])
                    redirect searchKeyword
                }
                '*' { respond searchKeyword, [status: OK] }
            }
        }

        @Transactional
        def delete(SearchKeyword searchKeyword) {

            if (searchKeyword == null) {
                transactionStatus.setRollbackOnly()
                notFound()
                return
            }

            searchKeyword.delete flush: true

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.deleted.message', args: [message(code: 'searchKeyword.label', default: 'SearchKeyword'), searchKeyword.id])
                    redirect action: "index", method: "GET"
                }
                '*' { render status: NO_CONTENT }
            }
        }

        protected void notFound() {
            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.not.found.message', args: [message(code: 'searchKeyword.label', default: 'SearchKeyword'), params.id])
                    redirect action: "index", method: "GET"
                }
                '*' { render status: NOT_FOUND }
            }
        }
    }*/
    }


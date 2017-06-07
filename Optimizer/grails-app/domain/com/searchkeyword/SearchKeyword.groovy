package com.searchkeyword

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes='search')
@ToString(includes='search', includeNames=true, includePackage=false)

class SearchKeyword implements Serializable {
    private static final long serialVersionUID = 1
    String search
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static constraints = {
        search nullable: false, blank: false, password: true
    }

}

package com.secure

import grails.plugin.springsecurity.annotation.Secured

class SecureController {
    @Secured('ROLE_ADMIN')
    def index() {
        render view: 'search_module'
    }
}

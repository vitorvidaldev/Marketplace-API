package dev.vitorvidal.marketplace.application.controller

import dev.vitorvidal.marketplace.application.service.AffiliateService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest/v1/affiliate")
class AffiliateController(val affiliateService: AffiliateService) {

}
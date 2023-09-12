package dev.vitorvidal.marketplace.application.controller

import dev.vitorvidal.marketplace.application.service.CommentService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest/v1/comment")
class CommentController(val commentService: CommentService) {

}
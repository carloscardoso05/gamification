package carlos.cardoso.gamification.controllers;

import carlos.cardoso.gamification.dtos.question.CreateQuestionRequest;
import carlos.cardoso.gamification.dtos.question.CreateQuestionResponse;
import carlos.cardoso.gamification.dtos.question.UpdateQuestionRequest;
import carlos.cardoso.gamification.dtos.question.UpdateQuestionResponse;
import carlos.cardoso.gamification.dtos.quiz.*;
import carlos.cardoso.gamification.entities.QuestionId;
import carlos.cardoso.gamification.entities.QuizId;
import carlos.cardoso.gamification.entities.User;
import carlos.cardoso.gamification.usecases.*;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
@RequiredArgsConstructor
@Tag(name = "Quizzes", description = "Quiz management")
public class QuizController {

    private final ListQuizzesUsecase listQuizzesUsecase;
    private final GetQuizByIdUsecase getQuizByIdUsecase;
    private final CreateQuizUsecase createQuizUsecase;
    private final UpdateQuizUsecase updateQuizUsecase;
    private final DeleteQuizUsecase deleteQuizUsecase;
    private final CreateQuestionUsecase createQuestionUsecase;
    private final UpdateQuestionUsecase updateQuestionUsecase;
    private final DeleteQuestionUsecase deleteQuestionUsecase;

    @GetMapping
    @Schema(description = "List all quizzes")
    @ArraySchema(schema = @Schema(implementation = QuizOverview.class, name = "ListQuizzesResponse"))
    public List<QuizOverview> listQuizzes(@AuthenticationPrincipal User currentUser) {
        return listQuizzesUsecase.execute(currentUser.getId());
    }

    @GetMapping("/{quizId}")
    @PreAuthorize("permissionService.isVisible(quizId)")
    public GetQuizByIdResponse getQuizById(@PathVariable QuizId quizId, @AuthenticationPrincipal User currentUser) {
        return getQuizByIdUsecase.execute(currentUser.getId(), quizId);
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public CreateQuizResponse createQuiz(@AuthenticationPrincipal User currentUser, @Valid @RequestBody CreateQuizRequest request) {
        return createQuizUsecase.execute(currentUser.getId(), request);
    }

    @PutMapping("/{quizId}")
    @PreAuthorize("permissionService.isOwner(quizId)")
    public UpdateQuizResponse updateQuiz(@PathVariable QuizId quizId, @Valid @RequestBody UpdateQuizRequest request) {
        return updateQuizUsecase.execute(quizId, request);
    }

    @DeleteMapping("/{quizId}")
    @PreAuthorize("permissionService.isOwner(quizId)")
    public ResponseEntity<Void> deleteQuiz(@PathVariable QuizId quizId) {
        deleteQuizUsecase.execute(quizId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{quizId}/questions")
    @PreAuthorize("permissionService.isOwner(quizId)")
    public CreateQuestionResponse createQuestion(@PathVariable QuizId quizId, @Valid @RequestBody CreateQuestionRequest request) {
        return createQuestionUsecase.execute(quizId, request);
    }

    @PutMapping("/{quizId}/questions/{questionId}")
    @PreAuthorize("permissionService.isOwner(questionId)")
    public UpdateQuestionResponse updateQuestion(@PathVariable QuestionId questionId, @Valid @RequestBody UpdateQuestionRequest request) {
        return updateQuestionUsecase.execute(questionId, request);
    }

    @DeleteMapping("/{quizId}/questions/{questionId}")
    @PreAuthorize("permissionService.isOwner(questionId)")
    public ResponseEntity<Void> deleteQuestion(@PathVariable QuestionId questionId) {
        deleteQuestionUsecase.execute(questionId);
        return ResponseEntity.noContent().build();
    }
}

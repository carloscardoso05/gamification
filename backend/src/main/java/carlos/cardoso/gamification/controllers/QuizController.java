package carlos.cardoso.gamification.controllers;

import carlos.cardoso.gamification.dtos.quiz.*;
import carlos.cardoso.gamification.entities.QuizId;
import carlos.cardoso.gamification.entities.User;
import carlos.cardoso.gamification.usecases.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final ListQuizzesUsecase listQuizzesUsecase;
    private final GetQuizByIdUsecase getQuizByIdUsecase;
    private final CreateQuizUsecase createQuizUsecase;
    private final UpdateQuizUsecase updateQuizUsecase;
    private final DeleteQuizUsecase deleteQuizUsecase;

    @GetMapping
    public List<QuizOverview> listQuizzes(@AuthenticationPrincipal User currentUser) {
        return listQuizzesUsecase.execute(currentUser.getId());
    }

    @GetMapping("/{quizId}")
    @PreAuthorize("permissionService.isVisible(quizId)")
    public GetQuizByIdResponse getQuizById(@PathVariable UUID quizId, @AuthenticationPrincipal User currentUser) {
        return getQuizByIdUsecase.execute(currentUser.getId(), new QuizId(quizId));
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public CreateQuizResponse createQuiz(@AuthenticationPrincipal User currentUser, @Valid @RequestBody CreateQuizRequest request) {
        return createQuizUsecase.execute(currentUser.getId(), request);
    }

    @PutMapping("/{quizId}")
    @PreAuthorize("permissionService.isOwner(quizId)")
    public UpdateQuizResponse updateQuiz(@PathVariable UUID quizId, @RequestBody UpdateQuizRequest request) {
        return updateQuizUsecase.execute(new QuizId(quizId), request);
    }

    @DeleteMapping("/{quizId}")
    @PreAuthorize("permissionService.isOwner(quizId)")
    public ResponseEntity<Void> deleteQuiz(@PathVariable UUID quizId) {
        deleteQuizUsecase.execute(new QuizId(quizId));
        return ResponseEntity.noContent().build();
    }
}

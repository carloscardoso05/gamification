import { Component, inject, OnInit, signal } from '@angular/core';
import { QuizService } from '../../services/quiz/quiz.service';
import { QuizOverview } from '../../models/quiz.model';
import { DatePipe } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-quizzes-page',
  standalone: true,
  imports: [DatePipe, RouterLink],
  templateUrl: './quizzes-page.component.html',
  styleUrl: './quizzes-page.component.css',
})
export class QuizzesPageComponent implements OnInit {
  private readonly quizService = inject(QuizService);

  readonly quizzes = signal<QuizOverview[]>([]);
  readonly loading = signal(false);
  readonly error = signal<string | null>(null);

  ngOnInit(): void {
    this.loading.set(true);
    this.quizService.listQuizzes().subscribe({
      next: (response) => {
        this.quizzes.set(response);
      },
      error: (error) => {
        this.error.set(error.message);
      },
      complete: () => {
        this.loading.set(false);
      },
    });
  }
}

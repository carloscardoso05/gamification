import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { QuizDetail, QuizOverview } from '../../models/quiz.model';

@Injectable({
  providedIn: 'root',
})
export class QuizService {
  private readonly http = inject(HttpClient);
  private readonly baseUrl = environment.apiUrl + '/quizzes';

  public listQuizzes(ownerId?: string) {
    return this.http.get<QuizOverview[]>(this.baseUrl, {
      params: ownerId ? { ownerId } : undefined,
    });
  }

  public getQuiz(id: string) {
    return this.http.get<QuizDetail>(`${this.baseUrl}/${id}`);
  }
}

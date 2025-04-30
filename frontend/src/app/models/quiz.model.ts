import User from './user.model';

export interface QuizOverview {
  id: number;
  description: string;
  owner: User;
  is_public: boolean;
  title: string;
  created_at: string;
  updated_at: string;
  questions_count: number;
  owner_id: User['id'];
}

export interface QuizDetail extends QuizOverview {
  questions: Question[];
}

export interface Question {
  id: string;
  text: string;
  difficulty: 'EASY' | 'MEDIUM' | 'HARD';
  answers: [Answer, Answer, Answer, Answer];
}

export interface Answer {
  text: string;
  correct: boolean;
}

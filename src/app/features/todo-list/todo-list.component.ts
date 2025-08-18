import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TodoFormComponent } from './todo-form-component';
import { Todo } from '../../core/models/todo.model';
import { TodoService } from '../../core/services/todo.service';


@Component({
  selector: 'app-todo-list',
  standalone: true,
  imports: [CommonModule, TodoFormComponent],
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {
  todos: Todo[] = [];

  constructor(private todoService: TodoService) {}

  ngOnInit() {
    this.loadTodos();
  }

  loadTodos() {
    this.todoService.getAll().subscribe(data => this.todos = data);
  }

  onAdd(todo: Todo) {
    this.todoService.create(todo).subscribe(() => this.loadTodos());
  }

  toggleCompletion(todo: Todo) {
    this.todoService.update({ ...todo, completed: !todo.completed })
      .subscribe(() => this.loadTodos());
  }

  deleteTodo(id: number) {
    this.todoService.delete(id).subscribe(() => this.loadTodos());
  }
}

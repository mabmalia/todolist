# User manual
This is the user manual for the todolist project.

## 1. Main menu
When the user starts the application, the main menu is displayed:

```
>> Welcome to MyToDo!
>> You have 1 tasks todo and 2 tasks done.
>> Pick an option:
>> (1) Show Task List (by date or project)
>> (2) Add New Task
>> (3) Edit Task (update, mark as done, remove)
>> (4) Save and Quit
```

On the top of the menu, the application displays the number of tasks done and todo:

```
>> You have 1 tasks todo and 2 tasks done.
```

If an invalid option is selected (5 or 6, for instance), a message is displayed as well as the main menu (after the user pressed Enter):

```
You typed an invalid command. Press (Enter) to continue.
```

If the user presses:

(1) - a **show menu** is displayed; that menu allows the user to see the tasks in the todo list;

(2) - is able to add new tasks to the todo list;

(3) - an **edit menu** is displayed; that menu allows the user to edit an existing task;

(4) - the application saves the current list of tasks and quits.

## 2. Show menu
If the user pressed (1), the show menu is displayed:

 ```
 >> Pick an option:
 >> (0) Return to main menu
 >> (1) Sort by project
 >> (2) Sort by due date
 ```

If an invalid option is selected (3 or 4, for instance), a message is displayed as well as the show menu (after the user pressed Enter):

```
You typed an invalid command. Press (Enter) to continue.
```

If the user presses:

(0) - the application returns to the main menu;

(1) - a list of tasks sorted by project is displayed;

(2) - a list of tasks sorted by date is displayed.

```
title = 'birlz', project = 'projec "X"', date = 2020-10-25, status = 'Done'
title = 'asfsg', project = 'alfa', date = 2022-09-13, status = 'To do'
title = 'tintol', project = 'project', date = 2222-10-15, status = 'Done'
>> Press Enter to return to previous menu.
```

After displaying the list of tasks and once the user pressed Enter, the application returns to main menu.


## 3. Add new task
If the user pressed (2), to add a new task to the todo list, the following sequence of actions is displayed:
* the application requests user to insert a task title:

```
>> Insert task title:
````

* and to insert a project title:

```
>> Insert project title:
```

* finally, requests user to insert a due date:

```
>> Insert due date (format yyyy-MM-dd):
```

Once the 3 fields were inserted, a new tas was created and added to the todo list:

```
Task was successfully created.
>> Press Enter to return to previous menu.
```

**NOTICE**: the fields can't be empty:

```
>> >> Field cannot be empty.
>> Press (Enter) to continue or (0) to return to main menu.
```

And the date must have the format yyyy-MM-dd:

```
>> Date with invalid format.
>> Press (Enter) to continue or (0) to return to main menu.
```

If the user presses (0) after entering an invalid input, the task creation is cancelled (and the application returns to the main menu after user pressed Enter):

```
A new task was not created.
>> Press Enter to return to previous menu.
```

## 4. Edit menu
If the user pressed (3), the edit menu is displayed:

```
>> Pick an option:
>> (0) Return to main menu
>> (1) Edit task details
>> (2) Mark task as done
>> (3) Remove task
```

If an invalid option is selected (4 or 5, for instance), a message is displayed as well as the edit menu (after the user pressed Enter):

```
You typed an invalid command. Press (Enter) to continue.
```

If the user presses:

(0) - the application returns to the main menu;

(1) - a list of tasks with index is displayed:

```
index = 1, title = 'tintol', project = 'project', date = 2222-10-15, status = 'Done'
index = 2, title = 'birlz', project = 'projec "X"', date = 2020-10-25, status = 'Done'
index = 3, title = 'asfsg', project = 'alfa', date = 2022-09-13, status = 'Done'
index = 4, title = 'birlz', project = 'X project', date = 2020-10-24, status = 'To do'
Select a task by inputting its index. Or press (0) to return to main menu.
```
And the user must select the index of a task to be edited:

```
The following task was selected:
index = 1, title = 'tintol', project = 'project', date = 2222-10-15, status = 'Done'
Press (Enter) to skip a field that doesn't need to be edited.
>> Insert task title:
```
 
The application will then request the user to insert a task title, a project title and a due date. Same sequence of actions as explained in `3. Add new task`. The only difference is that, during edit, a field can be skipped (not edited) by simply pressing Enter (leaving the field empty).
 
(2) - a list of tasks with index is displayed and the user must select the index of a task to be marked as done (as above); once an index was selected, the application changes the task status to "Done":

```
The following task was selected:
index = 1, title = 'tintol', project = 'project', date = 2222-10-15, status = 'Done'
Task was marked as done.
>> Press Enter to return to previous menu.
```

(3) - a list of tasks with index is displayed and the user must select the index of a task to be removed (as above); once an index was selected, the application removes the task from the todo list:

```
The following task was selected:
index = 5, title = 'addd', project = 'xpto', date = 2020-10-20, status = 'To do'
Task was successfully removed.
>> Press Enter to return to previous menu.
```

## 5. Save and quit
If the user pressed (4), the todo list is saved in a file (loaded to the program when the user starts the application next time) and the program stops execution:

```
Thank you for using MyToDo.
Now go and do some tasks!
```

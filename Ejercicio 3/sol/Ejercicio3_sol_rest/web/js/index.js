$(function(){

  fetch_tasks();

  $(document).on('click','a.delete',function(){
    return doDelete($(this));
  });

  $(document).on('click','a.post',function(){
    return doPost($(this));
  });

});


function fetch_tasks() {
  $.ajax({
    url: base + '/rest/task',
    method: 'GET',
    dataType: 'json',
    success: function(tasks) {
      fillTodoTasks(tasks.todo);
      fillDoneTasks(tasks.done);
    }
  });
}

function fillTodoTasks(tasks) {
  $(".todo").html('');
  tasks.forEach(function(task){
    var taskhtml = '<tr>';
    taskhtml += '<td>' + task.text + '</td>';
    taskhtml += '<td><a class="post" href="' + base + '/rest/task/' + task.id + '/done">Done</a></td>';
    taskhtml += '<td><a href="' + base + '/edit?id=' + task.id + '">Edit</a></td>';
    taskhtml += '<td><a class="delete" href="' + base + '/rest/task/' + task.id + '">Delete</a></td>';
    taskhtml += '</ tr>';
    $('.todo').append(taskhtml);
  });
}

function fillDoneTasks(tasks) {
  $(".done").html('');
  tasks.forEach(function(task){
    var taskhtml = '<tr>';
    taskhtml += '<td>' + task.text + '</td>';
    taskhtml += '<td><a class="post" href="' + base + '/rest/task/' + task.id + '/todo">Todo</a></td>';
    taskhtml += '<td><a href="' + base + '/edit?id=' + task.id + '">Edit</a></td>';
    taskhtml += '<td><a class="delete" href="' + base + '/rest/task/' + task.id + '">Delete</a></td>';
    taskhtml += '</ tr>';
    $('.done').append(taskhtml);
  });
}

// --------------

function doDelete(element) {
    if(confirm('This will completely delete the task.')) {

      $.ajax({
        url: element.attr('href'),
        method: 'delete',
        success: function() { fetch_tasks(); }
      });
    }
    return false;
}

// --------------

function doPost(element) {
    $.ajax({
      url: element.attr('href'),
      method: 'post',
      success: function() { fetch_tasks(); }
    });
    return false;
}
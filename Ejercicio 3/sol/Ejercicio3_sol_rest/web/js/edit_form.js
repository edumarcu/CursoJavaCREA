$(function() {

  $('form.put').submit(function() {
    return doForm($(this), 'PUT');
  });


  $('form.post').submit(function() {
    return doForm($(this), 'POST');
  });

});

function doForm(form, method) {

  $.ajax({
    type: method,
    url: form.attr("action"),
    data: JSON.stringify(form.serializeObject()),
    contentType: 'application/json',
    success: function() {
      window.location.href = base + "/index";
    },
    error: function() {
      alert('Ocurrió un error atendiendo a su solicitud.');
    }
  });
  return false;
}

$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
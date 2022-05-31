(function($) { // Begin jQuery
  $(function() { // DOM ready
    // If a link has a dropdown, add sub menu toggle.
    $('nav ul li a:not(:only-child)').click(function(e) {
      $(this).siblings('.nav-dropdown').toggle();
      // Close one dropdown when selecting another
      $('.nav-dropdown').not($(this).siblings()).hide();
      e.stopPropagation();
    });
    // Clicking away from dropdown will remove the dropdown class
    $('html').click(function() {
      $('.nav-dropdown').hide();
    });
    // Toggle open and close nav styles on click
    $('#nav-toggle').click(function() {
      $('nav ul').slideToggle();
    });
    // Hamburger to X toggle
    $('#nav-toggle').on('click', function() {
      this.classList.toggle('active');
    });
  }); // end DOM ready
})(jQuery); // end jQuery

'use strict'

function editRow(btn) {
  var fields = btn.closest('tr').querySelectorAll('.field');

  for (var i = 0; i < fields.length; i++) {
    fields[i].classList.add("editable");
    fields[i].setAttribute('contenteditable', true);
  }

  makeEdit(btn, true);
}

function cancelRow(btn) {
  var fields = btn.closest('tr').querySelectorAll('.field');

  for (var i = 0; i < fields.length; i++) {
    fields[i].classList.remove("editable");
    fields[i].setAttribute('contenteditable', false);
  }

  makeEdit(btn, false);
}

function makeEdit(btn, boolean) {
  var td = btn.parentElement;

  if (boolean) {
    td.querySelector('#cancelBtn').style.display = "inline-block";
    td.querySelector('#saveBtn').style.display = "inline-block";
    td.querySelector('#editBtn').style.display = "none";
    td.querySelector('#deleteBtn').style.display = "none";
  } else {
    td.querySelector('#cancelBtn').style.display = "none";
    td.querySelector('#saveBtn').style.display = "none";
    td.querySelector('#editBtn').style.display = "inline-block";
    td.querySelector('#deleteBtn').style.display = "inline-block";
  }
}

$('#deleteModal').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget);
  var id = button.data('whatever');
  var modal = $(this);
  console.log("id "+ id);
  modal.find('.modal-footer input').val(id)
});

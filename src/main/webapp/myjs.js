
$('.dropdown').hover(function() {
  $('.dropdown-content', this).slideDown(100);
}, function() {
  $('.dropdown-content', this).slideUp(100);
});

// Using pure JavaScript
var dropdowns = document.getElementsByClassName("dropdown");
for (var i = 0; i < dropdowns.length; i++) {
  dropdowns[i].addEventListener("mouseover", function() {
    this.getElementsByClassName("dropdown-content")[0].style.display = "block";
  });
  dropdowns[i].addEventListener("mouseout", function() {
    this.getElementsByClassName("dropdown-content")[0].style.display = "none";
  });
}

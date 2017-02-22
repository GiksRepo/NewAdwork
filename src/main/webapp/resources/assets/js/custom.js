$(function(){
$('a[title]').tooltip();
});

$('#myDropdown .dropdown-menu').on({
	"click":function(e){
      e.stopPropagation();
    }
});
$('#myDropdown2 .dropdown-menu').on({
	"click":function(e){
      e.stopPropagation();
    }
});
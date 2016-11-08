/**
 *  Show modal with question are you sure to remove ?
 */
$('document').ready(function(){		
	$('.triggerRemove').click(function(e){
			e.preventDefault();
			$('#modalRemoveInfo .removeBtn').attr("href", $(this).attr("href"));
			$('#modalRemoveInfo').modal();
	});		
});
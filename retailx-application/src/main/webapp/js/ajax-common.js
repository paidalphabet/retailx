function httpGetView(url, contentHtml){
    $.get(url, function(response){
         $("#" + contentHtml).html(response);
    });
}

function httpGet(url, element){
    $.get(url, function(response){
         $("#" + element).attr('value', response);
    });
}

function submitForm(formName, action, event){
/*
$( "#"+ formName ).submit(function( event ) {

  // Stop form from submitting normally
  event.preventDefault();

  // Get some values from elements on the page:
  var $form = $( this );
    url = action;

  // Send the data using post
  var posting = $.post( url, { data : new FormData(this) } );

  // Put the results in a div
  posting.done(function( data ) {
    var content = $( data ).find( "#content" );
    $( "#result" ).empty().append( content );
  });
});
*/
event.preventDefault();
//$.post( action, $( "#" + formName ).serialize() );

var form = $( "#" + formName );
var data = new FormData(form);
$.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: action,
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {
            },
            error: function (e) {
            }
        });


}
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

function submitForm(formName, action){
    var serializedForm = $("#"+formName).serialize();

     var url=$(this).attr("action");
        $.ajax({
            url: url,
            type: $(this).attr("method"),
            dataType: "JSON",
            data: new FormData(this),
            processData: false,
            contentType: false,
            success: function (data, status)
            {

            },
            error: function (xhr, desc, err)
            {


            }
          });

}
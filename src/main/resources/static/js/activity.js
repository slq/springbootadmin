$(document).ready(function () {
    $('#activity_table tr').click(function () {
        window.location = '/activity/' + $(this).find('td.activityid').text();
    });

    //$('#members_table tr').click(function () {
    //$(this).toggleClass('bg-info')
    //var $checkbox = $(this).find('input')
    //if($checkbox.is(':checked')){
    //$checkbox.prop('checked', false);
    //} else {
    //$checkbox.prop('checked', true);
    //}
    //});

    $('button').click(function () {
        window.location = '/activity/' + $(this).parent().parent().find('td.activityid').text()
    });
});


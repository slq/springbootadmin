$(document).ready(function () {
    $('#activity_table tr').click(function () {
        window.location = $(this).find('td.activityid').text();
    });
});

$('button').click(function () {
    alert('click');
});

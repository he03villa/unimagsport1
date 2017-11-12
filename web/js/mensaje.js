$(document).ready(function(){
    $('#futbol').click(function(){
        $('#res').append('&nbsp;&nbsp;&nbsp;<label>Futbol</label><br/>');
        swal('Haz agregado','Haz agregado Futbol','success');
        $("#deporte").modal("hide");
    });
    
    $('#lol').click(function(){
        $('#res').append('&nbsp;&nbsp;&nbsp;<label>League of Legends</label><br/>');
        swal('Haz agregado','Haz agregado League of Legends','success');
        $("#deporte").modal("hide");
    });
    
    $('#registrar').click(function () {
        swal('Haz agregado','Los datos se registraron','success');
    });
});
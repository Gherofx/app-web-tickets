$(document).on("click","#btnagregar",function(){
    $("#hddcphid").val("0");
    $("#txtdni").val("");
    $("#txtnombres").val("");
    $("#txtapellidos").val("");
    $("#txtdireccion").val("");
    $("#txttelefono").val("");
    $("#txtcorreo").val("");
    $("#modalNuevo").modal("show");
});

$(document).on("click",".btnactualizar",function(){
    $("#hddcphid").val($(this).attr("data-cphid"));
    $("#txtdni").val($(this).attr("data-cphdni"));
    $("#txtnombres").val($(this).attr("data-cphnombre"));
    $("#txtapellidos").val($(this).attr("data-cphapellido"));
    $("#txtdireccion").val($(this).attr("data-cphdirec"));
    $("#txttelefono").val($(this).attr("data-cphtel"));
    $("#txtcorreo").val($(this).attr("data-cphcorreo"));
    $("#modalNuevo").modal("show");
});

$(document).on("click","#btnguardar",function(){
    $.ajax({
        type: "POST",
        url: "/backoffice/ciudadano/guardar",
        contentType:"application/json",
        data: JSON.stringify({
            idciu: $("#hddcphid").val(),
            dniciu: $("#txtdni").val(),
            nombresc: $("#txtnombres").val(),
            apellidosc: $("#txtapellidos").val(),
            direccionc: $("#txtdireccion").val(),
            telefono: $("#txttelefono").val(),
            correoc: $("#txtcorreo").val(),

        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarCiudadanos()
            }
            alert(resultado.mensaje);
            $("#modalNuevo").modal("hide");
        }
    })
})

function listarCiudadanos(){
    $.ajax({
        type:"GET",
        url: "/backoffice/ciudadano/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblciudadano > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblciudadano > tbody").append("<tr>"+
                    "<td>"+value.idciu+"</td>"+
                    "<td>"+value.dniciu+"</td>"+
                    "<td>"+value.nombresc+"</td>"+
                    "<td>"+value.apellidosc+"</td>"+
                    "<td>"+value.direccionc+"</td>"+
                    "<td>"+value.telefono+"</td>"+
                    "<td>"+value.correoc+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'" +
                            " data-cphid='"+value.idciu+"'"+
                            " data-cphdni='"+value.dniciu+"'"+
                            " data-cphnombre='"+value.nombresc+"'"+
                            " data-cphapellido='"+value.apellidosc+"'"+
                            " data-cphdirec='"+value.direccionc+"'"+
                            " data-cphtel='"+value.telefono+"'"+
                            " data-cphcorreo='"+value.correoc+"'"+
                            "><i class='fas fa-edit'></i></button></td></tr>"
                );
            })
        }
    })
}
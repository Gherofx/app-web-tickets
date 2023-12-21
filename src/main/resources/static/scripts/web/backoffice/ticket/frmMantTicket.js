$(document).on("click","#btnagregar",function(){
    $("#cbodni").removeAttr("disabled");
    $("#cbodni").empty();
    $("#cboarea").empty();
    $("#hddboletoid").val("0");
    $("#txtobservacion").val("");
    $("#txttiempo").val(obtenerFechaHoraActual());
    $("#switchpreferencial").show();
    $("#chkpreferencial").empty();
    $("#cbostatus").empty();
    listarAreaCiudadanoStatus(0,0,0);
    $("#modalNuevo").modal("show");
});

$(document).on("click",".btnactualizar",function(){
    $("#cbodni").empty().prop("disabled", true);
    $("#cboarea").empty();
    $("#hddboletoid").val($(this).attr("data-boletoid"));
    $("#txtobservacion").val($(this).attr("data-boletoobs"));
    $("#txttiempo").val($(this).attr("data-boletotiempo"))
    $("#switchpreferencial").hide();
    if($(this).attr("data-boletopref") === "true")
        $("#chkpreferencial").prop("checked", true);
    else
        $("#chkpreferencial").prop("checked", false);
    $("#cbostatus").empty();
    listarAreaCiudadanoStatus($(this).attr("data-boletoarea"),$(this).attr("data-boletodni"),$(this).attr("data-boletoest"));
    $("#modalNuevo").modal("show");
});

$(document).on("click","#btnguardar",function(){
    $.ajax({
        type: "POST",
        url: "/backoffice/ticket/guardar",
        contentType:"application/json",
        data: JSON.stringify({
            idticket: $("#hddboletoid").val(),
            idciu: $("#cbodni").val(),
            idarea: $("#cboarea").val(),
            idstatus: $("#cbostatus").val(),
            preferencial: $("#chkpreferencial").prop("checked"),
            fregistro: $("#txttiempo").val(),
            observacion: $("#txtobservacion").val(),

        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarTickets()
            }
            alert(resultado.mensaje);
            $("#modalNuevo").modal("hide");
        }
    })
})

function obtenerFechaHoraActual() {
            var fechaHoraActual = new Date();
            var formatoFechaHora = `${fechaHoraActual.getFullYear()}-${fechaHoraActual.getMonth() + 1}-${fechaHoraActual.getDate()} ${fechaHoraActual.getHours()}:${fechaHoraActual.getMinutes()}:${fechaHoraActual.getSeconds()}`;
            return formatoFechaHora;
        }

function listarAreaCiudadanoStatus(idareamod,idciudadanoph,idestado){
    $.ajax({
        type: "GET",
        url: "/backoffice/area/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboarea").append(
                `<option value="${value.idarea}">${value.narea}</option>`
                )
            })
            if(idareamod > 0){
                $("#cboarea").val(idareamod);
            }

            $.ajax({
                    type: "GET",
                    url: "/backoffice/ciudadano/listar",
                    dataType: "json",
                    success: function(resultado){
                        $.each(resultado, function(index, value){
                            $("#cbodni").append(
                            `<option value="${value.idciu}">${value.dniciu}</option>`
                            )
                        })
                        if(idciudadanoph>0){
                            $("#cbodni").val(idciudadanoph);
                        }
                        $.ajax({
                                type: "GET",
                                url: "/backoffice/status/listar",
                                dataType: "json",
                                success: function(resultado){
                                    $.each(resultado, function(index, value){
                                        $("#cbostatus").append(
                                        `<option value="${value.idstatus}">${value.nstatus}</option>`
                                        )
                                    })
                                    if(idestado>0){
                                        $("#cbostatus").val(idestado);
                                    }
                                }
                        })
                    }
            })
        }
    })
}

function listarTickets(){
    $.ajax({
        type:"GET",
        url: "/backoffice/ticket/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblticket > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblticket > tbody").append("<tr>"+
                    "<td>"+value.idticket+"</td>"+
                    "<td>"+value.ciudadano.dniciu+"</td>"+
                    "<td>"+value.ciudadano.nombresc+"</td>"+
                    "<td>"+value.ciudadano.apellidosc+"</td>"+
                    "<td>"+value.area.narea+"</td>"+
                    "<td>"+value.observacion+"</td>"+
                    "<td>"+value.preferencial+"</td>"+
                    "<td>"+value.status.nstatus+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'" +
                            " data-boletoid='"+value.idticket+"'"+
                            " data-boletodni='"+value.ciudadano.idciu+"'"+
                            " data-boletonom='"+value.ciudadano.nombresc+"'"+
                            " data-boletoape='"+value.ciudadano.apellidosc+"'"+
                            " data-boletoarea='"+value.area.idarea+"'"+
                            " data-boletoobs='"+value.observacion+"'"+
                            " data-boletopref='"+value.preferencial+"'"+
                            " data-boletoest='"+value.status.idstatus+"'"+
                            " data-boletotiempo='"+value.fregistro+"'"+
                            "><i class='fas fa-edit'></i></button></td></tr>"
                );
            })
        }
    })
}
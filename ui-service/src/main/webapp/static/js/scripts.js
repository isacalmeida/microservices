
var url_path = window.location.pathname;
if(url_path === "/"){
    $("#menu-dashboard").addClass("active");
}
if(url_path === "/menu"){
    $("#menu-menu").addClass("active");
}
if(url_path.match(/ceps/) || url_path.match(/cidades/)
    || url_path.match(/estados/) || url_path.match(/pessoa/)){
    $("#menu-pessoa").addClass("active");
}

$('.datepicker').datepicker({
    autoclose: true,
    calendarWeeks: true,
    format: 'dd/mm/yyyy',
    language: 'pt-BR',
    showOnFocus: false,
    todayBtn: 'linked',
    todayHighlight: true
});

$(function () {
    var optionsCpf = {
        clearIfNotMatch: true
    };
    $('input[name=\'cpf\']').mask('000.000.000-00', optionsCpf);

    var optionsDinheiro = {
        clearIfNotMatch: true,
        reverse: true
    };
    $('.mask_dinheiro').mask("##0.00", optionsDinheiro);
});

$(function () {
    $('.select2').select2({
        placeholder: "",
        language: "pt-BR",
        width: '100%'
    });
});

$('button[data-select2-open]').on('click', function() {
    $('#' + $(this).data('select2-open')).select2('open');
});

$('.bootstrapSwitch').bootstrapSwitch();

$(function () {
    var optionsCep = {
        clearIfNotMatch: true,
        onComplete: function (cep) {
            $.ajax({
                url: 'https://viacep.com.br/ws/' + cep + '/json',
                dataType: 'json',
                success: function (json) {
                    if (json.erro) {
                        $('div[id=\'divCampoCep\']').addClass("has-error");
                    } else {
                        $('div[id=\'divCampoCep\']').removeClass("has-error").addClass("has-success");
                        if (json.complemento !== "")
                            $('input[name=\'logradouro\']').val(json.logradouro + " - " + json.complemento);
                        else
                            $('input[name=\'logradouro\']').val(json.logradouro);

                        $('select[name=\'cidade.id\']').select2({
                            ajax: {
                                url: '/busca/cidade',
                                type: 'POST',
                                contentType: 'application/json',
                                dataType: 'json',
                                data: JSON.stringify(
                                {
                                    "descricao": json.localidade,
                                    "estado": {
                                        "sigla": json.uf
                                    }
                                }),
                                processResults: function (data) {
                                    var items;
                                    items = $.map(data, function (obj) {
                                        obj.id = obj.id || obj.id;
                                        obj.text = obj.text || obj.descricao;
                                        if(data.length === 1) {
                                            obj.selected = true;
                                        }
                                        return obj;
                                    });

                                    return {
                                        results: items
                                    };
                                }
                            }
                        }).select2('open');

                        $('input[name=\'bairro\']').val(json.bairro);
                        $('input[name=\'ibge\']').val(json.ibge);
                    }
                }
            });
        }
    };
    $('input[name=\'cep\']').mask('00000000', optionsCep);
});
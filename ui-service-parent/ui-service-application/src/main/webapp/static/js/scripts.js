
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
if(url_path.match(/acesso/) || url_path.match(/perfis/)
    || url_path.match(/programas/) || url_path.match(/usuarios/)){
    $("#menu-acesso").addClass("active");
}

var tipoValue = $("#tipo").val();
if(tipoValue === 'FISICA'){
    $("#rowPessoaFisicaBasico").css("display", "block");
    $("#rowPessoaFisicaAdicional").css("display", "block");
    $("#rowPessoaJuridicaBasico").css("display", "none");
    $("#rowPessoaJuridicaAdicional").css("display", "none");
}
if(tipoValue === 'JURIDICA'){
    $("#rowPessoaFisicaBasico").css("display", "none");
    $("#rowPessoaFisicaAdicional").css("display", "none");
    $("#rowPessoaJuridicaBasico").css("display", "block");
    $("#rowPessoaJuridicaAdicional").css("display", "block");
}

var removerColuna;
$(function($){
    removerColuna = function(coluna) {
        $(coluna).remove();
    };
});

$(document).ready(function($){
   $(document).on("focus", ".maskTipoContato", function(){
	   var tipoContato, i;
	   for(i = 0; i < 10; i++){
		   
		   tipoContato = $("#select2-contatos"+ i +"tipo-container").text();
		   if(tipoContato === 'Celular' || tipoContato === 'Whatsapp'){
				$(this).mask('(00) 00000-0000');
		   }
		   if(tipoContato === 'Telefone Fixo'){
			   $(this).mask('(00) 0000-0000');
		   }
	   }
   });
});

$(document).ready(function($){
	$(document).on("focus", ".maskData", function(){
		var options = {
			clearIfNotMatch: true
		}
		$(this).mask('00/00/0000', options);	   
	});
});

$(document).ready(function($){
	$('.iCheck').iCheck({
	    checkboxClass: 'icheckbox_square-blue',
	    radioClass: 'iradio_square-blue'
	  });
});

$("#tipo").on("change", function () {
    var value = $(this).val();
    if(value === 'FISICA'){
        $("#rowPessoaFisicaBasico").css("display", "block");
        $("#rowPessoaFisicaAdicional").css("display", "block");
        $("#rowPessoaJuridicaBasico").css("display", "none");
        $("#rowPessoaJuridicaAdicional").css("display", "none");
    }
    if(value === 'JURIDICA'){
        $("#rowPessoaFisicaBasico").css("display", "none");
        $("#rowPessoaFisicaAdicional").css("display", "none");
        $("#rowPessoaJuridicaBasico").css("display", "block");
        $("#rowPessoaJuridicaAdicional").css("display", "block");
    }
});

$("#adicionarContato").on("click", function(){
    var count = $("#tableContato #linhaContato").length;

    var linha = $("<div id='linhaContato'>");

    var remover = "colunaContato"+ count;
    var coluna = "<div id='colunaContato"+ count +"'>";
    coluna +=
        "<div class='col-xs-12 col-sm-12 col-md-12 col-lg-12' style='padding-left: 5px; padding-right: 5px;'>" +
        "<hr style='margin-top: 5px; margin-bottom: 5px; border-top-color: #d2d6de;' />" +
        "</div>";
    coluna +=
        "<div class='form-group col-xs-12 col-sm-4 col-md-2 col-lg-2'>" +
        "<label for='contatos["+ count +"].id'>Id</label>" +
        "<input id='contatos["+ count +"].id' name='contatos["+ count +"].id' class='form-control' readonly='readonly' />" +
        "</div>";
    coluna +=
        "<div class='form-group col-xs-12 col-sm-8 col-md-3 col-lg-3'>" +
        "<label for='contatos["+ count +"].tipo'>Tipo</label>" +
        "<select id='contatos["+ count +"].tipo' name='contatos["+ count +"].tipo' class='form-control'></select>" +
        "</div>";
    coluna +=
        "<div class='form-group col-xs-12 col-sm-10 col-md-5 col-lg-5'>" +
        "<label for='contatos["+ count +"].descricao'>Descrição</label>" +
        "<input id='contatos["+ count +"].descricao' name='contatos["+ count +"].descricao' class='form-control maskTipoContato' />" +
        "</div>";
    coluna +=
        "<div class='form-group col-xs-12 col-sm-2 col-md-2 col-lg-2'>" +
        "<label for='removerContato"+ count +"'>Ação</label><br />" +
        "<input id='removerContato"+ count +"' type='button' class='btn btn-danger btn-flat form-control' value='Remover' onclick='removerColuna("+ remover +")' />" +
        "</div>";
    coluna += "</div>";

    linha.append(coluna);
    $("#tableContato").append(linha);

    $.ajax({
        url : '/pessoas/tipos/contato',
        success : function(data) {
            $("select[name='contatos["+ count +"].tipo']").append(data).select2();
        }
    });
    
});

$("#adicionarEndereco").on("click", function(){
    var count = $("#tableEndereco #linhaEndereco").length;

    var linha = $("<div id='linhaEndereco'>");

    var remover = "colunaEndereco"+ count;
    var coluna = "<div id='colunaEndereco"+ count +"'>";
    coluna +=
        "<div class='col-xs-12 col-sm-12 col-md-12 col-lg-12' style='padding-left: 5px; padding-right: 5px;'>" +
        "<hr style='margin-top: 5px; margin-bottom: 5px; border-top-color: #d2d6de;' />" +
        "</div>";
    coluna +=
        "<div class='form-group col-xs-12 col-sm-6 col-md-3 col-lg-3'>" +
        "<label for='enderecos["+ count +"].id'>Id</label>" +
        "<input id='enderecos["+ count +"].id' name='enderecos["+ count +"].id' class='form-control' readonly='readonly' />" +
        "</div>";
    coluna +=
        "<div class='form-group col-xs-12 col-sm-6 col-md-3 col-lg-3'>" +
        "<label for='enderecos["+ count +"].tipo'>Tipo</label>" +
        "<select id='enderecos["+ count +"].tipo' name='enderecos["+ count +"].tipo' class='form-control'></select>" +
        "</div>";
    coluna +=
        "<div class='form-group col-xs-12 col-sm-6 col-md-3 col-lg-3'>" +
        "<label for='enderecos["+ count +"].cep.cep'>Cep</label>" +
        "<input id='enderecos["+ count +"].cep.id' name='enderecos["+ count +"].cep.id' type='hidden' />" +
        "<input id='enderecos["+ count +"].cep.cep' name='enderecos["+ count +"].cep.cep' class='form-control' autocomplete='no' />" +
        "</div>";
    coluna +=
        "<div class='form-group col-xs-12 col-sm-6 col-md-3 col-lg-3'>" +
        "<label for='enderecos["+ count +"].numero'>Número</label>" +
        "<input id='enderecos["+ count +"].numero' name='enderecos["+ count +"].numero' class='form-control' />" +
        "</div>";
    coluna +=
        "<div class='form-group col-xs-12 col-sm-6 col-md-3 col-lg-3'>" +
        "<label for='enderecos["+ count +"].cep.bairro'>Bairro</label>" +
        "<input id='enderecos["+ count +"].cep.bairro' name='enderecos["+ count +"].cep.bairro' class='form-control' readonly='readonly' />" +
        "</div>";
    coluna +=
        "<div class='form-group col-xs-12 col-sm-6 col-md-3 col-lg-3'>" +
        "<label for='enderecos["+ count +"].cep.cidade.descricao'>Cidade - UF</label>" +
        "<input id='enderecos["+ count +"].cep.cidade.descricao' name='enderecos["+ count +"].cep.cidade.descricao' class='form-control' readonly='readonly' />" +
        "</div>";
    coluna +=
        "<div class='form-group col-xs-12 col-sm-6 col-md-6 col-lg-6'>" +
        "<label for='enderecos["+ count +"].cep.logradouro'>Logradouro</label>" +
        "<input id='enderecos["+ count +"].cep.logradouro' name='enderecos["+ count +"].cep.logradouro' class='form-control' readonly='readonly' />" +
        "</div>";
    coluna +=
        "<div class='form-group col-xs-12 col-sm-6 col-md-3 col-lg-3'>" +
        "<label for='enderecos["+ count +"].complemento'>Complemento</label>" +
        "<input id='enderecos["+ count +"].complemento' name='enderecos["+ count +"].complemento' class='form-control' />" +
        "</div>";
    coluna +=
        "<div class='form-group col-xs-12 col-sm-7 col-md-7 col-lg-7'>" +
        "<label for='enderecos["+ count +"].observacao'>Observação</label>" +
        "<input id='enderecos["+ count +"].observacao' name='enderecos["+ count +"].observacao' class='form-control' />" +
        "</div>";
    coluna +=
        "<div class='form-group col-xs-12 col-sm-5 col-md-2 col-lg-2'>" +
        "<label for='removerEndereco"+ count +"'>Ação</label><br />" +
        "<input id='removerEndereco"+ count +"' type='button' class='btn btn-danger btn-flat form-control' value='Remover' onclick='removerColuna("+ remover +")' />" +
        "</div>";
    coluna += "</div>";

    linha.append(coluna);
    $("#tableEndereco").append(linha);

    var optionsCep = {
        clearIfNotMatch: true
    };
    $("input[name='enderecos["+ count +"].cep.cep']").mask('00000000', optionsCep).autocomplete({
        serviceUrl: '/busca/cep',
        paramName: 'query',
        minChars: 3,
        showNoSuggestionNotice: true,
        noSuggestionNotice: "Nenhum Cep Encontrado",
        transformResult: function(response){
            var items;
            response = JSON.parse(response);
            items = $.map(response, function (obj) {
                obj.value = obj.cep;
                obj.data = obj.id;
                return obj;
            });
            return {
                suggestions: items
            };
        },
        onSelect: function(selection){
            $("input[name='enderecos["+ count +"].cep.id']").val(selection.id);
            $("input[name='enderecos["+ count +"].cep.bairro']").val(selection.bairro);
            $("input[name='enderecos["+ count +"].cep.cidade.descricao']").val(selection.cidade.descricao +" - "+ selection.cidade.estado.sigla);
            $("input[name='enderecos["+ count +"].cep.logradouro']").val(selection.logradouro);
        }
    });

    $.ajax({
        url : '/pessoas/tipos/endereco',
        success : function(data) {
            $("select[name='enderecos["+ count +"].tipo']").append(data).select2();
        }
    });
});



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
    
    var optionsCnpj = {
    	clearIfNotMatch: true
    }
    $('input[name=\'cnpj\']').mask('00.000.000/0000-00', optionsCnpj);

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


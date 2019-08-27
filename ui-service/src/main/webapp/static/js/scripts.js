
$('.datepicker').datepicker({
    autoclose: true,
    calendarWeeks: true,
    format: 'dd/mm/yyyy',
    language: 'pt-BR',
    showOnFocus: false,
    todayBtn: 'linked',
    todayHighlight: true
});

$(document).ready(function(){
    //var optionsData = {
    //	clearIfNotMatch: true
    //};
    //$('input[name*=\'data\']').mask('00/00/0000', optionsData);

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

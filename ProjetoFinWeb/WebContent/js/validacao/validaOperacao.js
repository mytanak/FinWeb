            $(document).ready( function() {
                $("#formOperacao").validate({
                    rules:{
                    	descricao:{
                            required: true, minlength: 2
                        },
                        tipo:{
                            required: true
                        },
                        codGrupo:{
                            required: true
                        }                
                    },
                    messages:{
                    	descricao:{
                            required: "Informe a descri��o",
                            minlength: "A descri��o deve conter, no m�nimo, 2 caracteres"
                        },
                        tipo:{
                            required: "Selecione um tipo"
                        },
                        codGrupo:{
                            required: "Selecione um grupo"
                        }
                    }
                });
            });

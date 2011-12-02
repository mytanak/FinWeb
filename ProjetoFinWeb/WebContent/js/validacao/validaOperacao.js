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
                            required: "Informe a descrição",
                            minlength: "A descrição deve conter, no mínimo, 2 caracteres"
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

            $(document).ready( function() {
                $("#formGrupo").validate({
                    rules:{
                    	descricao:{
                            required: true, minlength: 2
                        }
                    },
                    messages:{
                    	descricao:{
                            required: "Informe a descrição do Grupo",
                            minlength: "A descrição deve conter, no mínimo, 2 caracteres"
                        }
                    }
                });
            });

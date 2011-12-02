     $(document).ready( function() {
                $("#formModalidade").validate({
                    rules:{
                    	descricao:{
                            required: true, minlength: 2
                        }
                    },
                    messages:{
                    	descricao:{
                            required: "Informe a descrição",
                            minlength: "A descrição deve conter, no mínimo, 2 caracteres"
                        }
                    }
                });
            });

            $(document).ready( function() {
                $("#formConta").validate({
                    rules:{
                    	descricao:{
                            required: true, minlength: 2
                        }
                    },
                    messages:{
                    	descricao:{
                            required: "Informe a descri��o",
                            minlength: "A descri��o deve conter, no m�nimo, 2 caracteres"
                        }
                    }
                });
            });

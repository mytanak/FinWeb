      $(document).ready( function() {
                $("#formFornecedor").validate({
                    rules:{
                    	nome:{
                            required: true, minlength: 2
                        }
                    },
                    messages:{
                    	nome:{
                            required: "Informe o nome do fornecedor",
                            minlength: "O Nome deve conter, no m�nimo, 2 caracteres"
                        }
                    }
                });
            });

            $(document).ready( function() {
                $("#formUsuario").validate({
                    rules:{
                    	idUsuario:{
                            required: true, minlength: 5
                        },
                        nome:{
                            required: true, minlength: 5
                        },
                        senha:{
                            required: true, minlength: 6
                        },
                        confirmeSenha:{
                            required: true, minlength: 6, equalTo: "#senha"
                        },
                        email:{
                            required: true, email: true
                        },
                        dataNascimento:{
                            required: true
                        }
                    },
                    messages:{
                    	idUsuario:{
                            required: "Informe a identifica��o",
                            minlength: "A identifica��o deve conter, no m�nimo, 5 caracteres"
                        },
                        nome:{
                            required: "Informe o nome",
                            minlength: "O nome deve conter, no m�nimo, 5 caracteres"
                        },
                        senha:{
                            required: "Informe a senha",
                            minlength: "A senha deve conter, no m�nimo, 6 caracteres"
                        },
                        confirmeSenha:{
                            required: "Informe a senha",
                            minlength: "A senha deve conter, no m�nimo, 6 caracteres",
                            equalTo: "Por favor informe a mesma senha informada no campo Senha"
                        },
                        email:{
                            required: "Informe o seu e-mail para contato",
                            email: "Digite um e-mail v�lido"
                        },
                        dataNascimento:{
                            required: "Informe a data de nascimento"
                        }
                    }
                });
            });

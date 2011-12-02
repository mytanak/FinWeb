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
                            required: "Informe a identificação",
                            minlength: "A identificação deve conter, no mínimo, 5 caracteres"
                        },
                        nome:{
                            required: "Informe o nome",
                            minlength: "O nome deve conter, no mínimo, 5 caracteres"
                        },
                        senha:{
                            required: "Informe a senha",
                            minlength: "A senha deve conter, no mínimo, 6 caracteres"
                        },
                        confirmeSenha:{
                            required: "Informe a senha",
                            minlength: "A senha deve conter, no mínimo, 6 caracteres",
                            equalTo: "Por favor informe a mesma senha informada no campo Senha"
                        },
                        email:{
                            required: "Informe o seu e-mail para contato",
                            email: "Digite um e-mail válido"
                        },
                        dataNascimento:{
                            required: "Informe a data de nascimento"
                        }
                    }
                });
            });

﻿<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Cliente</h5> 
                <button class="close" data-dismiss="modal"> <span>&times;</span> </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/client?action=insert" method="POST" class="was-validated">
                
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Name</label>
                        <input type="text" class="form-control" name="nombre" required />
                    </div>
                    <div class="form-group">
                        <label for="apellido">Surname</label>
                        <input type="text" class="form-control" name="apellido" required />
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email" required>
                    </div>
                    <div class="form-group">
                        <label for="saldo">Balance</label>
                        <input type="number" class="form-control" name="saldo" required step="any" />
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Save</button>
                </div>    
            </form>
        </div>
    </div>
</div>
    
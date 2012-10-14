<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <h2>${requestScope.title}</h2>
   <h3>Entidades</h3>
   <form>
    <table>
     <thead>
      <tr><td>ID</td><td>Nome</td><td>e-mail</td><td>CNPJ</td><td>Qte. CER</td><td>Validação</td></tr>
     </thead>
     <c:forEach items="${listaEntidades}" var="ent">
      <tr>
       <td>${ent.id}</td>
       <td>${ent.nome}</td>
       <td>${ent.email}</td>
       <td>${ent.cnpj}</td>
       <td>${ent.quantidadeCER}</td>
       <td id="validacao_${ent.id}">
        ${ent.status.texto}
        <c:if test="${usuario.admin}">
         <c:if test="${ent.status != 'VALIDADA'}">
          &nbsp;<input type="button" value="Validar" onclick='validarEntidade("${appRoot}",${ent.id},true)' />
         </c:if>
         <c:if test="${ent.status != 'REPROVADA'}">
          &nbsp;<input type="button" value="Reprovar" onclick='validarEntidade("${appRoot}",${ent.id},false)' />
         </c:if>
        </c:if>
       </td>
      </tr>
     </c:forEach>
    </table>
   </form>
   <h3>Ranking das entidades</h3>
   <p>Padaria Pão Mole | 934234506 CER</p>
   <p>Apoio Atacadista | 10 CER</p>
   <p>Açougue São Judas | 2 CER</p>
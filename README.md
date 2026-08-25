<h1>Lista de Tarefas em Java</h1>

<p>Uma lista de tarefas desenvolvida em Java com o objetivo de permitir a criação e manipulação de tarefas de forma simples e rápida.</p>

<h2>Como utilizar</h2>

<p>Ao iniciar o programa, basta digitar o nome da tarefa e pressionar <code>Enter</code>.</p>

<p>Para adicionar uma descrição e/ou uma prioridade, utilize o seguinte formato:</p>

<pre><code>nome da tarefa: descrição #prioridade</code></pre>

<p>A descrição e a prioridade são opcionais.</p>

<h3>Limites</h3>

<ul>
  <li><strong>Nome da tarefa:</strong> máximo de 26 caracteres.</li>
  <li><strong>Descrição:</strong> máximo de 400 caracteres.</li>
  <li><strong>Prioridade:</strong> valores de 0 a 3.</li>
</ul>

<p>A prioridade funciona da seguinte forma:</p>

<ul>
  <li><code>0</code> — prioridade mais baixa</li>
  <li><code>3</code> — prioridade mais alta</li>
</ul>

<h2>Comandos</h2>

<p>Os comandos são utilizados para manipular as tarefas e consultar informações. Todos os comandos começam com <code>!</code>.</p>

<table>
  <thead>
    <tr>
      <th>Comando</th>
      <th>Sintaxe</th>
      <th>Descrição</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Concluir uma tarefa</td>
      <td><code>!concluir 'nome da tarefa'</code></td>
      <td>Marca a tarefa informada como concluída.</td>
    </tr>
    <tr>
      <td>Excluir uma tarefa</td>
      <td><code>!excluir 'nome da tarefa'</code></td>
      <td>Exclui a tarefa informada.</td>
    </tr>
    <tr>
      <td>Ver o histórico</td>
      <td><code>!historico</code></td>
      <td>Exibe as tarefas que já foram concluídas.</td>
    </tr>
    <tr>
      <td>Alterar uma tarefa</td>
      <td><code>!alterar 'nome da tarefa' oqAlterar 'valor'</code></td>
      <td>Permite modificar o nome, a descrição ou a prioridade da tarefa.</td>
    </tr>
  </tbody>
</table>

<p>O comando <code>!alterar</code> permite modificar as seguintes informações da tarefa:</p>

<table>
  <thead>
    <tr>
      <th>Informação</th>
      <th>Valor a ser utilizado</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Nome</td>
      <td><code>nome</code></td>
    </tr>
    <tr>
      <td>Descrição</td>
      <td><code>descricao</code></td>
    </tr>
    <tr>
      <td>Prioridade</td>
      <td><code>prioridade</code></td>
    </tr>
  </tbody>
</table>

<blockquote>
  <p><strong>Observação:</strong> ao utilizar o nome de uma tarefa nos comandos, coloque-o entre aspas simples (<code>' '</code>).</p>
</blockquote>
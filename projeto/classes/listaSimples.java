public class ListaSimples<Dado> where Dado : IComparable<Dado>
{
    private NoLista<Dado> primeiro, ultimo, anterior, atual;
    int quantosNos;

    private bool primeiroAcessoDoPercurso;

    public ListaSimples()
    {
        primeiro = ultimo = anterior = atual = null;
        quantosNos = 0;
        primeiroAcessoDoPercurso = false;
    }
    public void percorrerLista()
    {
        atual = primeiro;
        while (atual != null)
        {
            Console.WriteLine(atual.Info);
            atual = atual.Prox;
        }
    }

    public bool EstaVazia
    {
        get => primeiro == null;
    }
    public NoLista<Dado> Primeiro { get => primeiro; }
    public NoLista<Dado> Ultimo { get => ultimo; }
    public int QuantosNos { get => quantosNos; }
    public NoLista<Dado> Atual { get => atual; set => atual = value; }

    public void InserirAntesDoInicio(NoLista<Dado> novoNo)
    {
        if (EstaVazia)
            ultimo = novoNo;
        novoNo.Prox = primeiro;
        primeiro = novoNo;
        quantosNos++;
    }

    public void InserirAntesDoInicio(Dado informacao)
    {
        if (informacao != null)
        {
            var novoNo = new NoLista<Dado>(informacao, null);
            InserirAntesDoInicio(novoNo);
        }
    }

    public void InserirAposFim(NoLista<Dado> novoNo)
    {
        if (EstaVazia)
            primeiro = novoNo;
        else
            ultimo.Prox = novoNo;
        novoNo.Prox = null;
        ultimo = novoNo;
        quantosNos++;
    }

    public void InserirAposFim(Dado informacao)
    {
        if (informacao != null)
        {
            var novoNo = new NoLista<Dado>(informacao, null);
            InserirAposFim(novoNo);
        }
    }

    public void Listar(ListBox onde)
    {
        onde.Items.Clear();

        for (atual = primeiro; atual != null; atual = atual.Prox)
            onde.Items.Add(atual.Info);

        // ou
        // atual = primeiro;
        // while (atual != null)
        // {
        //    onde.Items.Add(atual.Info);
        //    atual = atual.Prox;
        // }
    }

  public bool ExisteDado(Dado outroProcurado)
  {
    anterior = null;
    atual = primeiro;

    // Em seguida, � verificado se a lista est� vazia. Caso esteja, �
    // retornado false ao local de chamada, indicando que a chave n�o foi
    // encontrada, e atual e anterior ficam valendo null

    if (EstaVazia)
      return false;

    // a lista n�o est� vazia, possui n�s
    // dado procurado � menor que o primeiro dado da lista:
    // portanto, dado procurado n�o existe

    if (outroProcurado.CompareTo(primeiro.Info) < 0)
      return false;

    // dado procurado � maior que o �ltimo dado da lista:
    // portanto, dado procurado n�o existe

    if (outroProcurado.CompareTo(ultimo.Info) > 0)
    {
      anterior = ultimo;
      atual = null;
      return false;
    }

    // caso n�o tenha sido definido que a chave est� fora dos limites de
    // chaves da lista, vamos procurar no seu interior

    // o apontador atual indica o primeiro n� da lista e consideraremos que
    // ainda n�o achou a chave procurada nem chegamos ao final da lista

    bool achou = false;
    bool fim = false;

    // repete os comandos abaixo enquanto n�o achou o RA nem chegou ao
    // final da lista
    while (!achou && !fim)
    {
      // se o apontador atual vale null, indica final da lista
      if (atual == null)
        fim = true;

      // se n�o chegou ao final da lista, verifica o valor da chave atual
      else
      // verifica igualdade entre chave procurada e chave do n� atual
      if (outroProcurado.CompareTo(atual.Info) == 0)
        achou = true;
      else
      // se chave atual � maior que a procurada, significa que
      // a chave procurada n�o existe na lista ordenada e, assim,
      // termina a pesquisa indicando que n�o achou. Anterior
      // aponta o anterior ao atual, que foi acessado por
      // �ltimo
      if (atual.Info.CompareTo(outroProcurado) > 0)
        fim = true;
      else
      {
        // se n�o achou a chave procurada nem uma chave > que ela,
        // ent�o a pesquisa continua, de maneira que o apontador
        // anterior deve apontar o n� atual e o apontador atual
        // deve seguir para o n� seguinte
        anterior = atual;
        atual = atual.Prox;
      }
    }
    // por fim, caso a pesquisa tenha terminado, o apontador atual
    // aponta o n� onde est� a chave procurada, caso ela tenha sido
    // encontrada, ou o n� onde ela deveria estar para manter a
    // ordena��o da lista. O apontador anterior aponta o n� anterior
    // ao atual
    return achou; // devolve o valor da vari�vel achou, que indica
                  // se a chave procurada foi ou n�o encontrado
}

  public void InserirEmOrdem(Dado dados)
  {
    if (!ExisteDado(dados)) // existeDado configurou anterior e atual
    {                       // aqui temos certeza de que a chave n�o existe
      NoLista<Dado> novo = new NoLista<Dado>(dados, null); // guarda dados no
                                                     // novo n�
      if (EstaVazia) // se a lista est� vazia, ent�o o
        InserirAntesDoInicio(novo); // novo n� � o primeiro da lista
      else
      if (anterior == null && atual != null)
        InserirAntesDoInicio(novo); // liga novo antes do primeiro
      else
        InserirNoMeio(novo); // insere entre os n�s anterior e atual
    }
  }
  private void InserirNoMeio(NoLista<Dado> novo)
  {
    // existeDado() encontrou intervalo de inclus�o do novo n�
    anterior.Prox = novo; // liga anterior ao novo
    novo.Prox = atual; // e novo no atual
    if (anterior == ultimo) // se incluiu ao final da lista,
      ultimo = novo; // atualiza o apontador ultimo
    quantosNos++; // incrementa n�mero de n�s da lista
  }

  public bool Remover(Dado dados)
  {
    if (!ExisteDado(dados))  // ajusta ponteiros atual e anterior
       return false;

    // aqui, temos certeza de que a lista n�o est� vazia,
    // que o dado procurado existe, e seu
    // n� � apontado pelo atributo atual.
    // O n� anterior � apontado pelo atributo anterior.

    RemoverNo(anterior, atual);

    return true;
  }
  protected void RemoverNo(NoLista<Dado> anterior, NoLista<Dado> atual)
  {
    if (anterior == null && atual != null) // o procurado � o 1o n�
    {
      primeiro = atual.Prox;
      if (primeiro == null) // lista ficou vazia
        ultimo = null;      // ajustamos ultimo para n�o ficar lixo
    }
    else
    {
      anterior.Prox = atual.Prox;
      if (atual == ultimo)
        ultimo = anterior;
    }
    quantosNos--;
  }

  private void ProcurarMenor(ref NoLista<Dado> antM,
                             ref NoLista<Dado> atuM)
  {
    antM = anterior = null;
    atuM = atual = primeiro;
    while (atual != null)
    {
      if (atual.Info.CompareTo(atuM.Info) < 0 )
      {
        antM = anterior;
        atuM = atual;
      }
      anterior = atual;
      atual = atual.Prox;
    }
  }
  public void Ordenar()
  {
    NoLista<Dado> menor = null, antMenor = null, noAIncluir = null;
    var listaOrdenada = new ListaSimples<Dado>();
    while (!this.EstaVazia)
    {
      ProcurarMenor(ref antMenor, ref menor);
      noAIncluir = menor;  // reaproveitamos os n�s da lista original
      this.RemoverNo(antMenor, menor);
      listaOrdenada.InserirAposFim(noAIncluir);
    }
    this.primeiro = listaOrdenada.primeiro;
    this.ultimo = listaOrdenada.ultimo;
    this.quantosNos = listaOrdenada.quantosNos;
    this.atual = this.anterior = null;
  }

  //////////////////////////////////////////////////////////////////
  // Exerc�cios
  //////////////////////////////////////////////////////////////////

  // Exerc�cio 1: percorrer e contar n�s
  public int Contar()
    {
        int quantos = 0;
        atual = primeiro;
        while (atual != null)
        {
            quantos++;
            atual = atual.Prox;
        }
        return quantos;
    }
    // Exercicio 3 : unir duas listas ligadas numa terceira

    public ListaSimples<Dado> UnirCom(ListaSimples<Dado> outra)
    {
        ListaSimples<Dado> novaLista = new ListaSimples<Dado>();
        atual = primeiro;
        outra.atual = outra.primeiro;
        while (atual != null && outra.atual != null)
        {
            if (atual.Info.CompareTo(outra.atual.Info) < 0)
            {
                novaLista.InserirAposFim(atual.Info);
                atual = atual.Prox;
            }
            else
              if (outra.atual.Info.CompareTo(atual.Info) < 0)
            {
                novaLista.InserirAposFim(outra.atual.Info);
                outra.atual = outra.atual.Prox;
            }
            else
            {
                novaLista.InserirAposFim(atual.Info);
                outra.atual = outra.atual.Prox;
                atual = atual.Prox;
            }

        }

        // se a lista this ainda n�o foi percorrida at� o final,
        // terminamos de percorr�-la e inclu�mos os elementos
        // faltantes na lista de uni�o (novaLista)
        while (atual != null)
        {
            novaLista.InserirAposFim(atual.Info);
            atual = atual.Prox;
        }

        // se a outra lista ainda n�o foi percorrida at� o final,
        // terminamos de percorr�-la e inclu�mos os elementos
        // faltantes na lista de uni�o (novaLista)
        while (outra.atual != null)
        {
            novaLista.InserirAposFim(outra.atual.Info);
            outra.atual = outra.atual.Prox;
        }

        return novaLista;
    }
    // Exerc�cio 4 : inverter uma lista ligada

    public void Inverter()
    {
        if (!EstaVazia)
        {
            NoLista<Dado> um, dois, tres;
            um = primeiro;
            dois = um.Prox;
            while (dois != null)
            {
                tres = dois.Prox;
                dois.Prox = um;
                um = dois;
                dois = tres;
            }
            ultimo = primeiro;
            primeiro = um;
            ultimo.Prox = null;
        }
    }
}
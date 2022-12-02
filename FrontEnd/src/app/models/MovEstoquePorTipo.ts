import { TipoProduto } from "./Produto";

export class MovEstoquePorTipo{
  id?: number;
  descricao!: string;
  estoque!: number;
  vendas!: number;
  valorFornecedor!: number;
  tipo!: TipoProduto;
}

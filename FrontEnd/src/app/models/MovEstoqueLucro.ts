import { TipoProduto } from "./Produto";

export class MovEstoqueLucro{
  id?: number;
  descricao!: string;
  estoque!: number;
  vendas!: number;
  lucroTotal!: number;
  tipo!: TipoProduto;
}

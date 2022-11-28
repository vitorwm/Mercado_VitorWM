export enum TipoProduto {
  ELETRONICO = "ELETRONICO",
  ELETRODOMESTICO = "ELETRODOMESTICO",
  MOVEL = "MOVEL"
}

export class Produto{
  id?: number;
  descricao!: string;
  tipoProduto!: TipoProduto;
  valorFornecedor!: number;
  estoque!: number;
}

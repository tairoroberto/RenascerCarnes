package br.com.tairoroberto.renascercarnes;


/**************************************************************************************/
/**	 			 				Classe de PRODUTOS									 */
/*************************** ********************************************************/
public class Produtos {

		private String fornecedor;
		private String nome;
		private int quantidadeSexta;
		private int tipoSexta;
		private int quantidadeSegunda;
		private int tipoSegunda;
		private boolean sexta;
		private boolean segunda;

		public Produtos() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Produtos(String nome) {
			super();
			
			this.nome = nome;
			
		}

		public String getFornecedor() {
			return fornecedor;
		}

		public void setFornecedor(String fornecedor) {
			this.fornecedor = fornecedor;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getQuantidadeSexta() {
			return quantidadeSexta;
		}

		public void setQuantidadeSexta(int quantidadeSexta) {
			this.quantidadeSexta = quantidadeSexta;
		}

		public int getTipoSexta() {
			return tipoSexta;
		}

		public void setTipoSexta(int tipoSexta) {
			this.tipoSexta = tipoSexta;
		}

		public int getQuantidadeSegunda() {
			return quantidadeSegunda;
		}

		public void setQuantidadeSegunda(int quantidadeSegunda) {
			this.quantidadeSegunda = quantidadeSegunda;
		}

		public int getTipoSegunda() {
			return tipoSegunda;
		}

		public void setTipoSegunda(int tipoSegunda) {
			this.tipoSegunda = tipoSegunda;
		}

		public boolean isSexta() {
			return sexta;
		}

		public void setSexta(boolean sexta) {
			this.sexta = sexta;
		}

		public boolean isSegunda() {
			return segunda;
		}

		public void setSegunda(boolean segunda) {
			this.segunda = segunda;
		}
}
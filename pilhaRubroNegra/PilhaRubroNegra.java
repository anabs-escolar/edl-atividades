public interface PilhaRubroNegra {
    public int size();
    public boolean isEmpty();
    public void pushR(Object o);
    public void pushN(Object o);
    public Object popR() throws PilhaVaziaExcecao;
    public Object popN() throws PilhaVaziaExcecao;
    public void grow();
    public void shrink();
    public Object topR() throws PilhaVaziaExcecao;
    public Object topN() throws PilhaVaziaExcecao;
}
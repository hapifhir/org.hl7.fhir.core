@Override
  public byte[] getContent() {
    return getData();
  }

  @Override
  public IBaseBinary setContent(byte[] arg0) {
    return setData(arg0);
  }

  @Override
  public Base64BinaryType getContentElement() {
    return getDataElement();
  }
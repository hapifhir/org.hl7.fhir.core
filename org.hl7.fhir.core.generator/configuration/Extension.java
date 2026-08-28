
    /**
     * Constructor
     *
     * @param context the model context this object belongs to (may be null)
     */
    public Extension(String url) {
      super();
      this.setUrl(url);
    }


    /**
     * Constructor
     */
    public Extension(String theUrl, IBaseDatatype theValue) {
      setUrl(theUrl);
      setValue(theValue);
    }

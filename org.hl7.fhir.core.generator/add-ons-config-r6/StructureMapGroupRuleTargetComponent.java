
    public String getElementName() {
        if (this.elementList == null || this.elementList.isEmpty()) {
            return null;
        } else if (this.elementList.size() == 1) {
            return this.elementList.get(0).getValue();
        } else {
          throw new FHIRException("Cannot call getElementName() when multiple elements exist");
        }
    }

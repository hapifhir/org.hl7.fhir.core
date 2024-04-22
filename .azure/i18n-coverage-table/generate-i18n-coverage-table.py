import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

#make this example reproducible
np.random.seed(0)

#define figure and axes
fig, ax = plt.subplots()

#hide the axes
fig.patch.set_visible(False)
ax.axis('off')
ax.axis('tight')

#read data
df = pd.read_csv('i18n-coverage.csv')
#create table
table = ax.table(cellText=df.values, colLabels=df.columns, loc='center')

#display table
fig.tight_layout()
#plt.show()

ax.set_title('Loss by Disaster')

fig = plt.gcf()


plt.savefig('pyplot-table-original.png',
            bbox_inches='tight',
            dpi=150
            )
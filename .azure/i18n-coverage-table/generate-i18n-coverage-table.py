import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

#define figure and axes
fig, ax = plt.subplots(1,1)

#hide the axes
fig.patch.set_visible(False)
ax.axis('off')
ax.axis('tight')

#read data
df = pd.read_csv('i18n-coverage.csv')
#create table
table = ax.table(cellText=df.values, colLabels=df.columns, loc='center')

table.scale(1, 4)
table.auto_set_font_size(False)
table.set_fontsize(14)

fig.tight_layout()
fig.set_figheight(2)
fig.set_figwidth(4)


ax.set_title('Internationalization Phrase Coverage by Locale')

fig = plt.gcf()

plt.savefig('i18n-coverage-table.png',
            bbox_inches='tight',
            dpi=150
            )
Ext.require([
    'AIDRFM.common.AIDRFMFunctions',
    'AIDRFM.common.StandardLayout',
    'AIDRFM.common.Header',
    'AIDRFM.common.Footer'
]);

Ext.define('TAGGUI.image-training-data.view.TrainingDataPanel', {
    extend: 'AIDRFM.common.StandardLayout',
    alias: 'widget.training-data-view',

    initComponent: function () {
        var me = this;

        this.breadcrumbs = Ext.create('Ext.form.Label', {
            html: '<div class="bread-crumbs">' +
                '<a href="' + BASE_URL + '/protected/home">My Collections</a><span>&nbsp;>&nbsp;</span>' +
                '<a href="' + BASE_URL + '/protected/' + CRISIS_CODE + '/collection-details">' + CRISIS_NAME + '</a><span>&nbsp;>&nbsp;</span>' +
                '<a href="' + BASE_URL + '/protected/' + CRISIS_CODE + '/tagger-collection-details">Classifier</a><span>&nbsp;>&nbsp;</span>' +
                '<span>&nbsp;>&nbsp;Human-tagged images</span></div>',
            margin: 0,
            padding: 0
        });

        this.taggerTitle = Ext.create('Ext.form.Label', {
            cls: 'header-h1 bold-text',
            // text: 'Human-tagged '+ COLLECTION_TYPES[TYPE]["plural"] + ' for "' + MODEL_NAME + '" in collection "' + CRISIS_NAME + '"',
            flex: 1
        });

        this.taggerDescription = Ext.create('Ext.form.Label', {
            cls: 'styled-text',
            margin: '0 0 30 0',
            //html: '<b>Status: </b>Waiting for more human-tagged images<br>',
            html: '<b>Status: </b>Running<br>',
            flex: 1
        });
/*
No use for this label as all the information is rendered in a single taggerDescription label
*/
        // this.taggerDescription2line = Ext.create('Ext.form.Label', {
        //     cls: 'styled-text',
        //     margin: '0 0 15 0',
        //     html: '<b>0</b> human-tagged '+ COLLECTION_TYPES[TYPE]["plural"] + '.',
        //     flex: 1
        // });

        this.addTrainingData = Ext.create('Ext.Button', {
            text: 'Tag more images',
            cls:'btn btn-greenBig',
            id: 'addNewTrainingData',
            width: 150,
            margin: '0 0 0 0'
        });

        this.trainingDataStore = Ext.create('Ext.data.Store', {
            pageSize: 20,
            storeId: 'trainingDataStore',

            fields: ['imageUrl', 'imageText', 'category', 'latitude', 'longitude', 'location'],
            remoteSort: true,
            proxy: {
                type: 'ajax',
                url: BASE_URL + '/protected/tagger/getTaggedImageDataByCrisisId.action',
                reader: {
                    rootProperty: 'data',
                    totalProperty: 'total'
                },
                simpleSortMode: true,
                sortParam: 'sortColumn',
                directionParam: 'sortDirection'
            },
            autoLoad: true,
            listeners: {
                beforeload: function (s) {
                    s.getProxy().setExtraParams({
                        crisisId: CRISIS_ID
                    })
                }
            }
        });

        this.trainingDataGrid = Ext.create('Ext.grid.Panel', {
            flex:1,
            store: this.trainingDataStore,
            cls: 'aidr-grid',
            columns: [
                {
                    xtype: 'gridcolumn', dataIndex: 'category', text: 'Category', width: 100,
                    renderer: function (value, meta, record) {
                        return me.getField(value);
                    }
                },
                {
                    xtype: 'gridcolumn', dataIndex: 'imageText', text: 'Text', flex: 1,
                    renderer: function (value, meta, record) {
			meta.style = "white-space: normal";
                        return me.getField(value);
                    }
                },
                {
                    xtype: 'gridcolumn', dataIndex: 'imageUrl', text: 'Thumbnail', width: 150,
                    renderer: function (value, meta, record) {
                        return '<a href="'+ value +'" target="_blank"><img width=128 height=150 src="' + value + '" /></a>';
                    }
                },
                {
                    xtype: 'gridcolumn', dataIndex: 'latitude', text: 'Latitude', width: 100,
                    renderer: function (value, meta, record) {
                        return me.getField(value);
                    }
                },
                {
                    xtype: 'gridcolumn', dataIndex: 'longitude', text: 'Longitude', width: 100,
                    renderer: function (value, meta, record) {
                        return me.getField(value);
                    }
                },
                {
                    xtype: 'gridcolumn', dataIndex: 'location', text: 'Location', width: 100,
                    renderer: function (value, meta, record) {
                        return me.getField(value);
                    }
                }
/*                {
                    xtype: 'gridcolumn', dataIndex: 'longitude', text: 'Lo', width: 95, sortable: false,
                    renderer: function (recordValue, metaData, record, rowIdx, colIdx, store) {

                        var id = Ext.id();

                        Ext.defer(function () {
                            Ext.widget('button', {
                                exampleId: recordValue,
                                renderTo: id,
                                cls: 'btn btn-redBig',
                                text: 'Delete',
                                width: 70,
                                action: 'deleteTrainingExample'
                            });
                        }, 50);

                        return Ext.String.format('<div class="margin-left" id="{0}"></div>', id);
                    }
                }*/
            ]
        });

        this.trainingDataPaging = Ext.create('Ext.toolbar.Paging', {
            cls: 'aidr-paging',
            margin: '12 2 0 2',
            store:'trainingDataStore',
            displayInfo:true,
            displayMsg:'Human-tagged images' + ' {0} - {1} of {2}',
            emptyMsg:'No human-tagged images to display'
        });
        //
/*        this.downloadTweetsL = Ext.create('Ext.form.Label', {
                			text: 'Download',
                			padding: '15 0 0 0',
                			cls: 'header-h2'
                		});

                this.downloadTweetsDescription = Ext.create('Ext.form.Label', {
                			text: 'Download Human-tagged tweets for all classifiers of this collection',
                			padding: '0 0 10 0'
                		});

                this.downloadFormat = Ext.create('Ext.form.RadioGroup', {
                			fieldLabel: 'Format',
                			labelWidth: 55,
                			columns: [150, 210, 240],
                			items: [
                			        {
                			        	boxLabel: 'Spreadsheet (.csv)',
                			        	name: 'format',
                			        	inputValue: 'csv',
                			        	checked: true
                			        },
                			        {
                			        	boxLabel: 'Single JSON object (.json)',
                			        	name: 'format',
                			        	inputValue: 'JSON'
                			        },
                			        {
                			        	boxLabel: 'One JSON per line (.txt-json)',
                			        	name: 'format',
                			        	inputValue: 'TEXT_JSON'
                			        }
                			        ],
        			        listeners: {
        						change: function(ctl, val) {
        							Ext.suspendLayouts();
        							Ext.getCmp('downloadLink').hide();
        						}
        					}
                		});

                this.downloadButton = Ext.create('Ext.Button', {
                			text: 'Generate Downloadable File',
                			cls:'btn btn-greenBig',
                			id: 'downloadButton',
                			margin: '10 0 0 0'
                		});

                this.downloadLink = Ext.create('Ext.form.Label', {
                			flex: 1,
                			margin: '10 5 5 5',
                			html: '',
                			width: 100,
                			id: 'downloadLink'
                		});

                this.downloadPanel = Ext.create('Ext.container.Container', {
                			layout: {
                				type: 'vbox'
                			},
                			items: [
                			        this.downloadTweetsL,
                			        this.downloadTweetsDescription,
                			        this.downloadFormat,
                			        {
                			        	xtype: 'container',
                			        	layout: 'hbox',
                			        	items: [
                			        	    this.downloadButton,
                			        	    this.downloadLink
                			        	]
                			        }
                			        ]
                		});*/
        //

        this.items = [
            this.breadcrumbs,
            {
                xtype: 'container',
                margin: '5 0 0 0',
                html: '<div class="horizontalLine"></div>'
            },
            {
                xtype: 'container',
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },
                items: [
                    this.taggerTitle,
                    {
                        xtype: 'container',
                        layout: 'hbox',
                        items: [
                            this.taggerDescription
                            //this.addTrainingData
                        ]
                    }
                ]
            },
            this.taggerDescription2line,
            {
                xtype: 'container',
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },
                items: [
						this.trainingDataGrid,
						this.trainingDataPaging,
                ]
            },


            this.downloadPanel
        ];



        this.callParent(arguments);
    },

    getField: function (r) {
        return r ? r : "<span class='na-text'>Not specified</span>";
    },

    getTwitterText: function (r) {
        var obj = Ext.JSON.decode(r);
        if (obj && obj.text) {
            return obj.text;
        } else if (obj && obj.message) {
        	return obj.message;
        } else {
            return "<span class='na-text'>Not specified</span>";
        }
    }

});

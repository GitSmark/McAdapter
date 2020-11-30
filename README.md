# McAdapter ![Android Arsenal](https://img.shields.io/badge/Android%20%20%20%20%20Arsenal-%20McAdapter%20-brightgreen.svg?style=flat) [![](https://img.shields.io/badge/JitPack-1.2.0-blue.svg)](https://jitpack.io/#GitSmark/McAdapter)
A very simple multilayer package CommonAdapter. 

------
|      [ListView+GridView]       |          [RecyclerView]          |           [ViewPager]          |
| :----------------------------: | :------------------------------: |  :---------------------------: |
|   `McAdapter`(CommonAdapter)   | `McRcvAdapter`(CommonRcvAdapter) |        CommonPagerAdapter      |

Usage
-----
  1. In project build.gradle
  ```
  repositories {
    maven {
      url "https://jitpack.io"
    }
  }
  ```
  2. In app build.gradle
  ```
  implementation 'com.github.GitSmark:McAdapter:1.2.0'
  ```
* Get your AdapterItem
 ```java
  public class MyAdapterItem extends McAdapterItem<String> {

      private TextView tv;

      @Override
      public int getLayoutResId() {
          return R.layout.layout_item;
      }

      @Override
      public void onBindViews(View root) {
          tv = (TextView) root.findViewById(R.id.item);
      }

      @Override
      public void onUpdateViews(String model) {
          tv.setText(model);
      }

      @Override
      public void onItemAction(int position) {
          //tv.setOnClickListener(this);
      }
  }
 ```
* Set your Adapter
 ```java
 
  listview.setAdapter(new McAdapter(data, McAdapterItem1.class));   
  
  listview.setAdapter(new McAdapter(list, McAdapterItem3.class, McAdapterItem4.class));
  
  listview.setAdapter(new CommonAdapter(data) {
      @NonNull
      @Override
      public IAdapterItem onCreateItem(Object type) {
          return new McAdapterItem2();
      }
  });
  
  listview.setAdapter(new CommonAdapter<McEntity>(list, 2) {
      @Override
      public Object getItemType(McEntity obj) {
          return obj.getItemType();
      }
      @NonNull
      @Override
      public IAdapterItem onCreateItem(Object type) {
          switch (((int) type)) {
              case 0:
                  return new McAdapterItem3();
              case 1:
                  return new McAdapterItem4();
              default:
                  throw new IllegalArgumentException("Illegal type");
          }
      }
  });
  
  ```

Sample
------
![Get it on Google Play](http://www.android.com/images/brand/get_it_on_play_logo_small.png)

Contact
--------
  Have problem? Just [tweet me](https://twitter.com/huangxy) or [send me an email](mailto:huangxy8023@foxmail.com).
  
  Thanks originator [tianzhijiexian](https://github.com/tianzhijiexian/CommonAdapter) and my friend [chenyp](https://github.com/chenyp1994).

License
----------

    Copyright 2016 huangxy@GitSmark

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



# TabBarSample

## Overview

* Khi bạn muốn chuyển đổi các chế độ xem khác nhau trong ứng dụng của bạn, hãy sử dụng TabLayout có trong thư viện **android.support.design** mà google cung cấp cho các lập trình viên.

* TabLayout được thiết kế để thêm các tab được scroll theo chiều ngang nếu như có nhiều tab trong 1 màn hình.

## Implement

### Basic TabLayout

* Thông thường TabLayout được kết hợp với ViewPager để tạo ra các tab khác nhau có thể thao tác vuốt hoặc là click.

* Thêm thư viện Support Design vào dependencies

```
implementation 'com.android.support:design:28.0.0'
```

* Thêm thẻ TabLayout vào bên trong giao diện chứa các tabs

```
<android.support.design.widget.TabLayout
        android:id="@+id/tabMain"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```

* Tạo thêm các tab bằng cách sử dụng phương thức **addTab()** và **newTab()**, có thể thêm các thuộc tính như Text, Icon cho tab khi tạo

```
tabMain.addTab(tabMain.newTab().setText("Home").setIcon(R.drawable.ic_home_24dp))
```

* Khi đã hiển thị được các tab, chúng ta cần xử lý các nội dung thay đổi khi chuyển qua lại các tab bằng sự kiện **OnTabSelectedListener**.

```
tabMain.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
        })
```
> Thông thường những nội dung cần thay đổi sẽ được hiển thị qua các Fragment được hiển thị luôn bên trong Activity và việc add hay replace fragment dựa vào các sự kiện chuyển tab.

* Bạn có thể điều chỉnh được tab nào sẽ được select đầu tiên thông qua phương thức **select()**.

```
tabMain.getTabAt(1)?.select()
```

### TabLayout with ViewPager
> Thông thường khi làm việc với tab, chúng ta sẽ có nhu cầu di chuyển giữa các tab bằng 

### Custom TabLayout

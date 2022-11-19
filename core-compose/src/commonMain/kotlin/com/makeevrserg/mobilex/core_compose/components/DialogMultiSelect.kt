package com.makeevrserg.mobilex.core_compose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxColors
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.makeevrserg.mobilex.core_compose.components.expandable.LineType

@Composable
@Deprecated("Possibly need to refactor")
fun <Item> DialogMultiSelect(
    items: Map<Item, Boolean>,
    checkboxColors: CheckboxColors,
    shape: Shape = RoundedCornerShape(8.dp),
    backgroundColor: Color,
    title: @Composable () -> Unit={},
    separator: LineType = LineType.None,
    onDismiss: (Map<Item, Boolean>) -> Unit,
    itemTextBuilder: @Composable (Item) -> Unit,
    onItemClicked: (Int, Item, Boolean) -> Unit,
    postfixIcon: @Composable (Item) -> Unit = {},
    footer: @Composable () -> Unit = {},
) {

    Dialog(onDismissRequest = { onDismiss.invoke(items) }) {
        Surface(
            modifier = Modifier.fillMaxWidth(0.9f),
            shape = shape,
            color = backgroundColor
        ) {

            Column {
                title()
                separator.Create()

                LazyColumn(
                    modifier = Modifier
                        .fillMaxHeight(0.8f)
                        .fillMaxWidth(),
                ) {
                    itemsIndexed(items.entries.toList()) { i, mapEntry ->
                        val value = mapEntry.value
                        val item = mapEntry.key
                        Row(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Checkbox(
                                    checked = value,
                                    onCheckedChange = {
                                        onItemClicked.invoke(i, item, value)
                                    },
                                    enabled = true,
                                    colors = checkboxColors
                                )
                                itemTextBuilder.invoke(item)
                            }
                            postfixIcon.invoke(item)

                        }
                    }

                }
                footer()
            }
        }
    }
}